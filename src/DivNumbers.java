import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;

import static org.objectweb.asm.Opcodes.*;

public class DivNumbers {

	public static void main(String[] args) throws IOException{
		
		ClassWriter cw=new ClassWriter(0);
		cw.visit(V11, ACC_PUBLIC+ACC_SUPER, "Divide", null, "java/lang/Object", null);
	
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
			MethodVisitor methodVisitor=cw.visitMethod(ACC_PUBLIC+ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(3, label0);
            methodVisitor.visitIntInsn(BIPUSH, 12);
            methodVisitor.visitVarInsn(ISTORE, 1);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(4, label1);
            methodVisitor.visitIntInsn(BIPUSH, 24);
            methodVisitor.visitVarInsn(ISTORE, 2);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(5, label2);
            methodVisitor.visitLdcInsn((Double)12.4);
            methodVisitor.visitVarInsn(DSTORE, 3);
            Label label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(6, label3);
            methodVisitor.visitLdcInsn((Double)24.1);
            methodVisitor.visitVarInsn(DSTORE, 5);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(7, label4);
            methodVisitor.visitLdcInsn((long)72);
            methodVisitor.visitVarInsn(LSTORE, 7);
            Label label5 = new Label();
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(8, label5);
            methodVisitor.visitLdcInsn((long)21);
            methodVisitor.visitVarInsn(LSTORE, 9);
            Label label6 = new Label();
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLineNumber(9, label6);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(ILOAD, 1);
            methodVisitor.visitVarInsn(ILOAD, 2);
            methodVisitor.visitInsn(IDIV);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            Label label7 = new Label();
            methodVisitor.visitLabel(label7);
            methodVisitor.visitLineNumber(10, label7);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(DLOAD, 3);
            methodVisitor.visitVarInsn(DLOAD, 5);
            methodVisitor.visitInsn(DDIV);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
            Label label8 = new Label();
            methodVisitor.visitLabel(label8);
            methodVisitor.visitLineNumber(11, label8);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(LLOAD, 7);
            methodVisitor.visitVarInsn(LLOAD, 9);
            methodVisitor.visitInsn(LDIV);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            Label label9 = new Label();
            methodVisitor.visitLabel(label9);
            methodVisitor.visitLineNumber(12, label9);
            methodVisitor.visitInsn(RETURN);
            Label label10 = new Label();
            methodVisitor.visitLabel(label10);
            methodVisitor.visitLocalVariable("args", "[Ljava/lang/String;", null, label0, label10, 0);
            methodVisitor.visitLocalVariable("i", "I", null, label1, label10, 1);
            methodVisitor.visitLocalVariable("i2", "I", null, label2, label10, 2);
            methodVisitor.visitLocalVariable("d", "D", null, label3, label10, 3);
            methodVisitor.visitLocalVariable("d2", "D", null, label4, label10, 5);
            methodVisitor.visitLocalVariable("l", "J", null, label5, label10, 7);
            methodVisitor.visitLocalVariable("l2", "J", null, label6, label10, 9);
            methodVisitor.visitMaxs(5, 11);
            methodVisitor.visitEnd();
		}
		
		//save bytecode into disk
		FileOutputStream out=new FileOutputStream("../bin/Divide.class");
		out.write(cw.toByteArray());
		out.close();

	}//end main

}//end class