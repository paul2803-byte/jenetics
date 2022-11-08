package io.jenetics.incubator.property;

import static java.util.Collections.emptyIterator;

import java.util.Iterator;
import java.util.Map;

public final class MapProperty extends IterableProperty {

	MapProperty(
		final PropertyDescription desc,
		final Object enclosingObject,
		final Path path,
		final Object value
	) {
		super(desc, enclosingObject, path, value);
	}

	public int size() {
		return value != null ? value().size() : 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterator<Object> iterator() {
		return value != null
			? (Iterator<Object>)(Object)value().entrySet().iterator()
			: emptyIterator();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<Object, Object> value() {
		return (Map<Object, Object>)value;
	}

	@Override
	public String toString() {
		return Properties.toString(getClass().getSimpleName(), this);
	}

}
