package com.github.bw.capricorn.server.endpoint.util;

/**
 * 各种奇葩校验
 * <p>
 * Inspired by Guava
 *
 * @author zhangyunan
 */
public final class Preconditions {

  private Preconditions() {
  }

  public static void checkGTZero(Integer param) {
    if (param == null || param <= 0) {
      throw new PreconditionException();
    }
  }

  public static void checkGTZero(Integer param, String errorMessage) {
    if (param == null || param <= 0) {
      throw new PreconditionException(errorMessage);
    }
  }

  public static void checkGTZero(Integer param, String errorMessageTemplate,
      Object... errorMessageArgs) {
    if (param == null || param <= 0) {
      throw new PreconditionException(String.format(errorMessageTemplate, errorMessageArgs));
    }
  }

  public static void checkRange(int param, int min, int max) {
    if (param < min || param > max) {
      throw new PreconditionException();
    }
  }

  public static void checkRange(int param, int min, int max, String errorMessage) {
    if (param < min || param > max) {
      throw new PreconditionException(errorMessage);
    }
  }


  /**
   * Check argument.
   *
   * @param expression the expression
   */
  public static void checkArgument(boolean expression) {
    if (!expression) {
      throw new PreconditionException();
    }
  }

  /**
   * Check argument.
   *
   * @param expression   the expression
   * @param errorMessage the error message
   */
  public static void checkArgument(boolean expression, String errorMessage) {
    if (!expression) {
      throw new PreconditionException(errorMessage);
    }
  }

  /**
   * Check argument.
   *
   * @param expression           the expression
   * @param errorMessageTemplate the error message template
   * @param errorMessageArgs     the error message args
   */
  public static void checkArgument(
      boolean expression,
      String errorMessageTemplate,
      Object... errorMessageArgs) {
    if (!expression) {
      throw new PreconditionException(String.format(errorMessageTemplate, errorMessageArgs));
    }
  }

  public static void checkNull(Object reference) {
    if (reference != null) {
      throw new PreconditionException();
    }
  }

  public static void checkNull(
      Object reference, String errorMessage) {
    if (reference != null) {
      throw new PreconditionException(errorMessage);
    }
  }

  public static void checkNull(
      Object reference,
      String errorMessageTemplate,
      Object... errorMessageArgs) {
    if (reference != null) {
      throw new PreconditionException(String.format(errorMessageTemplate, errorMessageArgs));
    }
  }

  /**
   * Check not null.
   *
   * @param reference the reference
   */
  public static void checkNotNull(Object reference) {
    if (reference == null) {
      throw new PreconditionException();
    }
  }

  /**
   * Check not null.
   *
   * @param reference    the reference
   * @param errorMessage the error message
   */
  public static void checkNotNull(
      Object reference, String errorMessage) {
    if (reference == null) {
      throw new PreconditionException(errorMessage);
    }
  }

  /**
   * Check not null.
   *
   * @param reference            the reference
   * @param errorMessageTemplate the error message template
   * @param errorMessageArgs     the error message args
   */
  public static void checkNotNull(
      Object reference,
      String errorMessageTemplate,
      Object... errorMessageArgs) {
    if (reference == null) {
      throw new PreconditionException(String.format(errorMessageTemplate, errorMessageArgs));
    }
  }
}
