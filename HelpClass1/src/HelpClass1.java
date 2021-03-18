import javax.swing.JOptionPane;

public class HelpClass1 {

	public static void main(String[] args) {
		boolean finished=false;
		do
		{
			String input= JOptionPane.showInputDialog("Enter three numbers seperated by spaces(or to exit enter 'exit'));
			if(input.hasNext("exit"))
			{
				finished=true
			}
		}while(false);

	}

}
