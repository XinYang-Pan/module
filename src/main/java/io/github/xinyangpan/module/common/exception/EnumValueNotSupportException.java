package io.github.xinyangpan.module.common.exception;

public class EnumValueNotSupportException extends LogicException {

	private static final long serialVersionUID = -5583096044573623842L;

	public EnumValueNotSupportException(Enum<?> enum_) {
		super(enum_ + " is not supported");
	}

	public <E extends Enum<E>> EnumValueNotSupportException(Class<E> clazz, E enum_) {
		super(enum_ + " is not supported for " + clazz);
	}

}
