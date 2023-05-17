package me.serce.solidity.ide

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object SolidityIcons {
  val FILE_ICON: Icon = IconLoader.getIcon("/icons/sol-file.svg", SolidityIcons::class.java)
  val CONTRACT: Icon = IconLoader.getIcon("/icons/sol-contract.svg", SolidityIcons::class.java)
  val ABSTRACT_CONTRACT: Icon = IconLoader.getIcon("/icons/sol-abstract_contract.svg", SolidityIcons::class.java)
  val LIBRARY: Icon = IconLoader.getIcon("/icons/sol-library.svg", SolidityIcons::class.java)
  val INTERFACE: Icon = IconLoader.getIcon("/icons/sol-interface.svg", SolidityIcons::class.java)

  val FUNCTION: Icon = IconLoader.getIcon("/icons/sol-function.svg", SolidityIcons::class.java)
  val VIEW_FUNCTION: Icon = IconLoader.getIcon("/icons/sol-view-function.svg", SolidityIcons::class.java)

  val MODIFIER: Icon = IconLoader.getIcon("/icons/sol-modifier.svg", SolidityIcons::class.java)
  val ENUM: Icon = IconLoader.getIcon("/icons/sol-enum.svg", SolidityIcons::class.java)
  val EVENT: Icon = IconLoader.getIcon("/icons/sol-event.svg", SolidityIcons::class.java)
  val STRUCT: Icon = IconLoader.getIcon("/icons/sol-struct.svg", SolidityIcons::class.java)

  val STATE_VAR: Icon = IconLoader.getIcon("/icons/sol-state.svg", SolidityIcons::class.java)


  val ERROR: Icon = IconLoader.getIcon("/icons/sol-error.svg", SolidityIcons::class.java)


  val PUBLIC: Icon = IconLoader.getIcon("/icons/sol-public.svg", SolidityIcons::class.java)
  val PRIVATE: Icon = IconLoader.getIcon("/icons/sol-private.svg", SolidityIcons::class.java)
}
