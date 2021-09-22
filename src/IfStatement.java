import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;

import static org.objectweb.asm.Opcodes.*;

public class IfStatement {

	public static void main(String[] args) throws IOException{
		
		ClassWriter cw=new ClassWriter(0);
		cw.visit(V11, ACC_PUBLIC+ACC_SUPER, "IfElse", null, "java/lang/Object", null);
	
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
            methodVisitor.visitIntInsn(BIPUSH, 44);
            methodVisitor.visitVarInsn(ISTORE, 2);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(5, label2);
            methodVisitor.visitVarInsn(ILOAD, 1);
            methodVisitor.visitVarInsn(ILOAD, 2);
            Label label3 = new Label();
            methodVisitor.visitJumpInsn(IF_ICMPLE, label3);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(6, label4);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(ILOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            Label label5 = new Label();
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(7, label5);
            Label label6 = new Label();
            methodVisitor.visitJumpInsn(GOTO, label6);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(8, label3);
            methodVisitor.visitFrame(Opcodes.F_APPEND,2, new Object[] {Opcodes.INTEGER, Opcodes.INTEGER}, 0, null);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(ILOAD, 2);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLineNumber(10, label6);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitInsn(RETURN);
            Label label7 = new Label();
            methodVisitor.visitLabel(label7);
            methodVisitor.visitLocalVariable("args", "[Ljava/lang/String;", null, label0, label7, 0);
            methodVisitor.visitLocalVariable("i1", "I", null, label1, label7, 1);
            methodVisitor.visitLocalVariable("i2", "I", null, label2, label7, 2);
            methodVisitor.visitMaxs(2, 3);
            methodVisitor.visitEnd();
		}
		
		//save bytecode into disk
		FileOutputStream out=new FileOutputStream("../bin/IfElse.class");
		out.write(cw.toByteArray());
		out.close();

	}//end main

}//end class
