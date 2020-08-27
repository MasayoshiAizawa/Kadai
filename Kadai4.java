import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class Kadai4 implements ActionListener {
	private JFrame mainFrame;//フレームの作成
	private JButton addButton;//ボタンの作成
	private JButton clearButton;//ボタンの作成
	private Container contentPane;
	private JLabel textlabel;//テキストラベルの作成
	int count = 0;//カウンターの設定
	
	//フレームの設定
	public Kadai4(){
		mainFrame = new JFrame("CheckUp");//フレームを名前付きで作榮
		mainFrame.setSize(600,600);//フレームの大きさ設定
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//フレームを閉じると同時にプログラムを終了にする
		mainFrame.setLayout(new FlowLayout());//コンポーネントの配置設定
		contentPane = mainFrame.getContentPane();
		textlabel = new JLabel();
		
		addButton = new JButton("カウントアップ");//名前付きでボタン設定
		addButton.addActionListener(this);//イベント処理
		mainFrame.add(addButton);//ボタンの追加
		
		clearButton = new JButton("リセット");//名前付きでボタン設定
		clearButton.addActionListener(this);//イベント処理
		mainFrame.add(clearButton);//ボタンの追加
		
		mainFrame.add(textlabel);//イベント処理で作成したテキストの表示
		
		mainFrame.setVisible(true);
	}
	//イベント処理の設定
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == addButton){//押したボタンを確認
			count++;//カウンターに1を追加
			textlabel.setText(count + "回");//テキストを設定
		}
		if(event.getSource() == clearButton){//押したボタンの確認
			count = 0;//カウンターをリセットする
			textlabel.setText(count + "回");//テキストを設定
		}
	}
	
	public static void main(String[] args) {
		new Kadai4();
	}
}
