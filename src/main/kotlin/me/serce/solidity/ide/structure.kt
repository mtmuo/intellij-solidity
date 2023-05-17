package me.serce.solidity.ide

import com.intellij.ide.structureView.*
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.ide.util.treeView.smartTree.*
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import me.serce.solidity.lang.core.SolidityFile
import me.serce.solidity.lang.psi.*
import me.serce.solidity.lang.psi.impl.SolFunctionDefMixin
import me.serce.solidity.lang.psi.impl.SolStateVarDeclMixin

class PublicFilter : Filter {
  override fun isVisible(treeNode: TreeElement): Boolean {
    if (treeNode is SolLeafTreeElement && treeNode.element is SolFunctionDefMixin) {
      return (treeNode.element as SolFunctionDefMixin).visibility == Visibility.PUBLIC || (treeNode.element as SolFunctionDefMixin).visibility == Visibility.EXTERNAL
    }
    if (treeNode is SolLeafTreeElement && treeNode.element is SolStateVarDeclMixin) {
      return (treeNode.element as SolStateVarDeclMixin).visibility == Visibility.PUBLIC || (treeNode.element as SolStateVarDeclMixin).visibility == Visibility.EXTERNAL
    }
    return true
  }

  override fun getPresentation(): ActionPresentation {
    return ActionPresentationData("私有", "", SolidityIcons.PRIVATE)
  }

  override fun getName(): String {
    return "PublicFilter"
  }

  override fun isReverted(): Boolean {
    return true
  }
}

class StateFilter : Filter {
  override fun isVisible(treeNode: TreeElement): Boolean {
    return !(treeNode is SolLeafTreeElement && treeNode.element is SolStateVarDeclMixin)
  }

  override fun getPresentation(): ActionPresentation {
    return ActionPresentationData("变量", "", SolidityIcons.STATE_VAR)
  }

  override fun getName(): String {
    return "StateFilter"
  }

  override fun isReverted(): Boolean {
    return true
  }
}

class InterfaceFilter : Filter {
  override fun isVisible(treeNode: TreeElement): Boolean {
    return !(treeNode is SolContractTreeElement && treeNode.element is SolContractOrLibElement && (treeNode.element as SolContractOrLibElement).contractType == ContractType.INTERFACE)
  }

  override fun getPresentation(): ActionPresentation {
    return ActionPresentationData("接口", "", SolidityIcons.INTERFACE)
  }

  override fun getName(): String {
    return "InterfaceFilter"
  }

  override fun isReverted(): Boolean {
    return true
  }
}

class LibraryFilter : Filter {
  override fun isVisible(treeNode: TreeElement): Boolean {
    return return !(treeNode is SolContractTreeElement && treeNode.element is SolContractOrLibElement && (treeNode.element as SolContractOrLibElement).contractType == ContractType.LIBRARY)
  }

  override fun getPresentation(): ActionPresentation {
    return ActionPresentationData("显示支持库", "", SolidityIcons.LIBRARY)
  }

  override fun getName(): String {
    return "LibraryFilter"
  }

  override fun isReverted(): Boolean {
    return true
  }
}

class ViewFilter : Filter {
  override fun isVisible(treeNode: TreeElement): Boolean {
    return !(treeNode is SolLeafTreeElement && treeNode.element is SolFunctionDefMixin && (treeNode.element as SolFunctionDefMixin).isView)
  }

  override fun getPresentation(): ActionPresentation {
    return ActionPresentationData("VIEW方法", "", SolidityIcons.VIEW_FUNCTION)
  }

  override fun getName(): String {
    return "VIEW_FILTER"
  }

  override fun isReverted(): Boolean {
    return true
  }
}

class SolPsiStructureViewFactory : PsiStructureViewFactory {
  override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder {
    val solFile = psiFile as SolidityFile
    return object : TreeBasedStructureViewBuilder() {
      override fun createStructureViewModel(editor: Editor?): StructureViewModel {
        return SolStructureViewModel(editor, solFile)
      }
    }
  }
}

class SolStructureViewModel(editor: Editor?, file: SolidityFile) : TextEditorBasedStructureViewModel(editor, file), StructureViewModel.ElementInfoProvider {

  override fun getRoot() = SolTreeElement(psiFile)

  override fun getPsiFile(): SolidityFile = super.getPsiFile() as SolidityFile

  override fun isAlwaysShowsPlus(element: StructureViewTreeElement) = false

  override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
    if (element.value is SolidityFile || element.value is SolContractDefinition) {
      return false
    }
    return true
  }

  override fun getSorters(): Array<Sorter> {
    return arrayOf(Sorter.ALPHA_SORTER)
  }

  override fun getFilters(): Array<Filter> {
    return arrayOf(
      PublicFilter(),
      StateFilter(),
      ViewFilter(),
      InterfaceFilter(),
      LibraryFilter(),
    )
  }
}

class SolTreeElement(item: SolElement) : PsiTreeElementBase<SolElement>(item) {
  override fun getPresentableText() = element?.containingFile?.name
  override fun getChildrenBase(): Collection<StructureViewTreeElement> {
    val el = element ?: return emptyList()
    return listOf(el.children.filterIsInstance(SolContractDefinition::class.java).map(::SolContractTreeElement)).flatten().sortedBy { it.element?.textOffset }
  }
}

class SolContractTreeElement(item: SolContractDefinition) : SortableTreeElement, PsiTreeElementBase<SolContractDefinition>(item) {
  override fun getPresentableText() = element?.name

  override fun getAlphaSortKey(): String {
    return element?.name ?: ""
  }

  override fun getChildrenBase(): Collection<StructureViewTreeElement> = element?.let {
    listOf(
      it.stateVariableDeclarationList.map(::SolLeafTreeElement),
      it.enumDefinitionList.map(::SolLeafTreeElement),
      it.structDefinitionList.map(::SolLeafTreeElement),
      it.constructorDefinitionList.map(::SolLeafTreeElement),
      it.modifierDefinitionList.map(::SolLeafTreeElement),
      it.functionDefinitionList.map(::SolLeafTreeElement),
    ).flatten()
  } ?: emptyList()
}

class SolLeafTreeElement(item: SolNamedElement) : SortableTreeElement, PsiTreeElementBase<SolNamedElement>(item) {

  override fun getPresentableText(): String? {
    if (element is SolFunctionDefinition && (element as SolFunctionDefinition).modifiers.isNotEmpty()) {
      return (element as SolFunctionDefinition).name + "@" + (element as SolFunctionDefinition).modifiers.map{ it.referenceName }.toString()
    }
    return element?.name
  }

  override fun getChildrenBase(): Collection<StructureViewTreeElement> = emptyList()

  override fun getAlphaSortKey(): String {
    return element?.name ?: ""
  }
}
