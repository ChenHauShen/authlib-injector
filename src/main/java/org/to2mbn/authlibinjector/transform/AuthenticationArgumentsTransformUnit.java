package org.to2mbn.authlibinjector.transform;

import static java.util.Collections.emptyMap;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ASM5;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.to2mbn.authlibinjector.AuthlibInjector.log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.to2mbn.authlibinjector.internal.org.json.JSONObject;
import org.to2mbn.authlibinjector.login.yggdrasil.AuthInfo;
import org.to2mbn.authlibinjector.util.UUIDUtils;

public class AuthenticationArgumentsTransformUnit implements TransformUnit {

	public static String[] __injectArgs(String[] _input) {
		String[] args = _input.clone();
		List<String> result = new ArrayList<>(Arrays.asList(args));

		log("original main args: ", result);

		Map<String, String> argsTable = createArgumentsTable();
		for (int idx = 0; idx < result.size(); idx++) {
			String opt = result.get(idx);
			String replaceNextTo = argsTable.get(opt);
			if (replaceNextTo != null) {
				if (idx < result.size() - 1) {
					result.set(idx + 1, replaceNextTo);
					idx++;
				} else {
					result.add(replaceNextTo);
					break;
				}
			}
		}
		log("modified main args: ", result);

		return result.toArray(new String[0]);
	}

	private static Map<String, String> createArgumentsTable() {
		if (authInfo == null) {
			log("authInfo is not set, argument replacement cannot be done!");
			return emptyMap();
		}

		Map<String, String> table = new LinkedHashMap<>();
		table.put("--username", authInfo.getUsername());
		table.put("--uuid", UUIDUtils.unsign(authInfo.getUUID()));
		table.put("--accessToken", authInfo.getToken());
		table.put("--userType", authInfo.getUserType());
		table.put("--userProperties", new JSONObject(authInfo.getProperties()).toString());
		table.put("--session", authInfo.getToken());
		return table;
	}

	public static AuthInfo authInfo;

	@Override
	public Optional<ClassVisitor> transform(String className, ClassVisitor writer, Runnable modifiedCallback) {
		if ("net.minecraft.client.main.Main".equals(className)) {
			return of(new ClassVisitor(ASM5) {

				@Override
				public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
					if ("main".equals(name) && "([Ljava/lang/String;)V".equals(desc)) {
						MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
						mv.visitVarInsn(ALOAD, 0);
						mv.visitMethodInsn(INVOKESTATIC, Type.getInternalName(AuthenticationArgumentsTransformUnit.class), "__injectArgs", "([Ljava/lang/String;)[Ljava/lang/String;", false);
						mv.visitVarInsn(ASTORE, 0);
						return mv;
					} else {
						return super.visitMethod(access, name, desc, signature, exceptions);
					}
				}
			});
		}
		return empty();
	}

}
