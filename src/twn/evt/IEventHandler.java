package twn.evt;

@FunctionalInterface
public interface IEventHandler<T extends EventArgs> {
	public void handleEvent(Object sender, final T eventArgs);
}
