import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.*;

public class CompNums {

	public static void main(String[] args) throws IOException{
		
		ClassWriter cw=new ClassWriter(0);
		cw.visit(V11, ACC_PUBLIC+ACC_SUPER, "Compare", null, "java/lang/Object", null);
	
		//Create the class
		{
			MethodVisitor mv=cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}
		
		//create the main method
		{
			MethodVisitor mv=cw.visitMethod(ACC_PUBLIC+ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
			mv.visitCode();
			
            mv.visitLdcInsn(63.21);
			mv.visitVarInsn(DSTORE,1);
			mv.visitLdcInsn(34.51);
			mv.visitVarInsn(DSTORE,3);
			mv.visitVarInsn(DLOAD,1);
			mv.visitVarInsn(DLOAD,3);
			mv.visitInsn(DCMPG);
			mv.visitVarInsn(ISTORE,5);
			mv.visitFieldInsn(GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
			mv.visitVarInsn(ILOAD,5);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

			mv.visitInsn(RETURN); 
			mv.visitMaxs(4, 7);
			mv.visitEnd();
		}
		
		//save bytecode into disk
		FileOutputStream out=new FileOutputStream("../bin/Compare.class");
		out.write(cw.toByteArray());
		out.close();

	}//end main

}//end class