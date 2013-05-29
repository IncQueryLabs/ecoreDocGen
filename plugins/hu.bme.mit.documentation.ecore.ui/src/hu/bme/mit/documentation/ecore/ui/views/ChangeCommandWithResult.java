package hu.bme.mit.documentation.ecore.ui.views;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.command.ChangeCommand;

/**
 * Command that returns a result of type T.
 * 
 * @author adam
 *
 * @param <T>
 */
public class ChangeCommandWithResult<T> extends ChangeCommand {

	T returnValue = null;
	private final Callable<T> callable;
	
	public ChangeCommandWithResult(Callable<T> callable,Notifier n) {
		super(n);
		this.callable = callable;
	}

	@Override
	protected void doExecute() {
		try {
			returnValue = callable.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T getReturnValue(){
		return returnValue;
	}
	
	@Override
	public Collection<?> getResult() {
		if (returnValue instanceof Collection<?>) {
			Collection<?> coll = (Collection<?>) returnValue;
			return coll;
		}
		return Collections.singletonList(returnValue);
	}
}
