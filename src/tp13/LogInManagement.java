package tp13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogInManagement {
	public final String LOGIN = "Patoche";
	public final String PWD = "coucou";
	
	private void checkPassWord(String passI) throws NotPasswordException{
		if(!this.PWD.equals(passI)) throw new NotPasswordException();
	}
	private void checkLogin(String log) throws NotLoginException{
		if(!this.LOGIN.equals(log)) throw new NotLoginException();
	}
	private void checkLength(int l) throws LengthException{
		if(l>10) throw new LengthException();
	}
	public static void main(String[] args) {
		LogInManagement gc = new LogInManagement();
		boolean end = false;
		System.out.println("login start");
		while(!end) {
			try {
				end= true;
				gc.isUserPwd();
			}catch (LengthException e) {
				e.printStackTrace();
				end=false;
			}catch (NotLoginException e) {
				e.printStackTrace();
				end=false;
			}catch (NotPasswordException e) {
				e.printStackTrace();
				end=false;
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("sucess login");
	}
	public void isUserPwd() throws IOException, NotLoginException,NotPasswordException,LengthException{
		
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Login ?");
				String inp = br.readLine();
				this.checkLength(inp.length());
				this.checkLogin(inp);
				System.out.println("password ?");
				inp = br.readLine();
				this.checkLength(inp.length());
				this.checkPassWord(inp);
				br.close();
		
	}
	
	
}
