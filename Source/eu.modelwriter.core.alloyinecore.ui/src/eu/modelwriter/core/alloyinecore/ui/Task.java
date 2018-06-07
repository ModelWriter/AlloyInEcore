package eu.modelwriter.core.alloyinecore.ui;

import java.util.concurrent.Callable;

import org.eclipse.core.runtime.SubMonitor;

class Task implements Callable<Boolean> {
	SubMonitor subMonitor;
	public Task(SubMonitor subMonitor) {
		this.subMonitor = subMonitor;
	}
    @Override
    public Boolean call() throws Exception {
		// the pseudo process to delay the system
		for (int i = 0; i < 5; i++) {
			try {
				// We simulate a long running operation here
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new InterruptedException();
			}
			System.out.println("Doing something");
//			subMonitor.split(10);
		}
        return true;
    }
}
