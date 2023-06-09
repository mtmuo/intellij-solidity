package me.serce.solidity.ide

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object SolidityIcons {
  val FILE_ICON: Icon = IconLoader.getIcon("/icons/sol-file.svg", SolidityIcons::class.java)
  val CONTRACT: Icon = IconLoader.getIcon("/icons/sol-contract.svg", SolidityIcons::class.java)
  val ABSTRACT_CONTRACT: Icon = IconLoader.getIcon("/icons/sol-contract-abstract.svg", SolidityIcons::class.java)
  val LIBRARY: Icon = IconLoader.getIcon("/icons/sol-library.svg", SolidityIcons::class.java)
  val INTERFACE: Icon = IconLoader.getIcon("/icons/sol-interface.svg", SolidityIcons::class.java)

  val FUNCTION: Icon = IconLoader.getIcon("/icons/sol-function.svg", SolidityIcons::class.java)
  val FUNCTION_CONSTRUCTOR: Icon = IconLoader.getIcon("/icons/sol-function-constructor.svg", SolidityIcons::class.java)
  val FUNCTION_VIEW: Icon = IconLoader.getIcon("/icons/sol-function-view.svg", SolidityIcons::class.java)
  val FUNCTION_PAYABLE: Icon = IconLoader.getIcon("/icons/sol-function-payable.svg", SolidityIcons::class.java)
  val FUNCTION_FALLBACK: Icon = IconLoader.getIcon("/icons/sol-function-fallback.svg", SolidityIcons::class.java)


  val MODIFIER: Icon = IconLoader.getIcon("/icons/sol-modifier.svg", SolidityIcons::class.java)
  val ENUM: Icon = IconLoader.getIcon("/icons/sol-enum.svg", SolidityIcons::class.java)
  val EVENT: Icon = IconLoader.getIcon("/icons/sol-event.svg", SolidityIcons::class.java)
  val STRUCT: Icon = IconLoader.getIcon("/icons/sol-struct.svg", SolidityIcons::class.java)

  val VARIABLE: Icon = IconLoader.getIcon("/icons/sol-variable.svg", SolidityIcons::class.java)
  val VARIABLE_READ_ONLY: Icon = IconLoader.getIcon("/icons/sol-variable-read.svg", SolidityIcons::class.java)

  val ERROR: Icon = IconLoader.getIcon("/icons/sol-error.svg", SolidityIcons::class.java)

  val PUBLIC: Icon = IconLoader.getIcon("/icons/sol-public.svg", SolidityIcons::class.java)
  val PRIVATE: Icon = IconLoader.getIcon("/icons/sol-private.svg", SolidityIcons::class.java)

  val FUNCTION_CONSTRUCTOR_PUBLIC: Icon = com.intellij.ui.RowIcon(FUNCTION_CONSTRUCTOR, PUBLIC)
  val FUNCTION_CONSTRUCTOR_PRIVATE: Icon = com.intellij.ui.RowIcon(FUNCTION_CONSTRUCTOR, PRIVATE)

  val FUNCTION_PUBLIC: Icon = com.intellij.ui.RowIcon(FUNCTION, PUBLIC)
  val FUNCTION_PRIVATE: Icon = com.intellij.ui.RowIcon(FUNCTION, PRIVATE)

  val FUNCTION_VIEW_PUBLIC: Icon = com.intellij.ui.RowIcon(FUNCTION_VIEW, PUBLIC)
  val FUNCTION_VIEW_PRIVATE: Icon = com.intellij.ui.RowIcon(FUNCTION_VIEW, PRIVATE)

  val FUNCTION_PAYABLE_PUBLIC: Icon = com.intellij.ui.RowIcon(FUNCTION_PAYABLE, PUBLIC)
  val FUNCTION_FALLBACK_PUBLIC: Icon = com.intellij.ui.RowIcon(FUNCTION_FALLBACK, PUBLIC)

  val VARIABLE_PUBLIC: Icon = com.intellij.ui.RowIcon(VARIABLE, PUBLIC)
  val VARIABLE_PRIVATE: Icon = com.intellij.ui.RowIcon(VARIABLE, PRIVATE)

  val VARIABLE_READ_ONLY_PUBLIC: Icon = com.intellij.ui.RowIcon(VARIABLE_READ_ONLY, PUBLIC)
}
