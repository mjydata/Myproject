package sychronize.pool;

import java.util.concurrent.Executor;

public class myexecutor implements Executor{
    public static void main() {
		new Thread(()->new myexecutor().execute(()->{
			System.out.println("executor");
		})).start();;
	}
	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		command.run();
	}

}
