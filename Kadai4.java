import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class Kadai4 implements ActionListener {
	private JFrame mainFrame;//�t���[���̍쐬
	private JButton addButton;//�{�^���̍쐬
	private JButton clearButton;//�{�^���̍쐬
	private Container contentPane;
	private JLabel textlabel;//�e�L�X�g���x���̍쐬
	int count = 0;//�J�E���^�[�̐ݒ�
	
	//�t���[���̐ݒ�
	public Kadai4(){
		mainFrame = new JFrame("CheckUp");//�t���[���𖼑O�t���ō��
		mainFrame.setSize(600,600);//�t���[���̑傫���ݒ�
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�t���[�������Ɠ����Ƀv���O�������I���ɂ���
		mainFrame.setLayout(new FlowLayout());//�R���|�[�l���g�̔z�u�ݒ�
		contentPane = mainFrame.getContentPane();
		textlabel = new JLabel();
		
		addButton = new JButton("�J�E���g�A�b�v");//���O�t���Ń{�^���ݒ�
		addButton.addActionListener(this);//�C�x���g����
		mainFrame.add(addButton);//�{�^���̒ǉ�
		
		clearButton = new JButton("���Z�b�g");//���O�t���Ń{�^���ݒ�
		clearButton.addActionListener(this);//�C�x���g����
		mainFrame.add(clearButton);//�{�^���̒ǉ�
		
		mainFrame.add(textlabel);//�C�x���g�����ō쐬�����e�L�X�g�̕\��
		
		mainFrame.setVisible(true);
	}
	//�C�x���g�����̐ݒ�
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == addButton){//�������{�^�����m�F
			count++;//�J�E���^�[��1��ǉ�
			textlabel.setText(count + "��");//�e�L�X�g��ݒ�
		}
		if(event.getSource() == clearButton){//�������{�^���̊m�F
			count = 0;//�J�E���^�[�����Z�b�g����
			textlabel.setText(count + "��");//�e�L�X�g��ݒ�
		}
	}
	
	public static void main(String[] args) {
		new Kadai4();
	}
}
