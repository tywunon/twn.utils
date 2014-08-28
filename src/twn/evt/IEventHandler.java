package twn.evt;

/**
 * The Interface IEventHandler.
 * This Interface had to be implemented, in order to receive Events.
 *
 * @param <T> the generic type
 */
@FunctionalInterface
public interface IEventHandler<T extends EventArgs> {
	public void handleEvent(Object sender, final T eventArgs);
}
