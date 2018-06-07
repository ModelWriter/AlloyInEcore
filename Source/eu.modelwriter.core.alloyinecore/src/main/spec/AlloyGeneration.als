open util/graph[Type] as graph

open util/ordering[Level] as ord

sig Level { level: set Type}
fact{ all t: Type | one t.~level}
fun layer [] : Type -> Level {~level}

sig Instance { 
	--slot: Type ->  Instance
} {some this.~instance}

sig Type {
	xtends: set Type,
	subTypes: set Type,
--	reference: set Type,
    instance : set Instance,
}
fact {graph/dag[xtends] }
fact {subTypes = ~xtends}

fun Type.allSubTypes [] : set Type { this.^~xtends }
fun Type.allExtends [] : set Type { this.^xtends }
fun Instance.getType : Type { this.~instance }

sig AbstractType extends Type {}

one sig Object extends AbstractType {}
fact ObjectIsGreatestElement {Type in Object.*~xtends}

one sig Null extends Type {}
fact {no Null.instance and no Null.~xtends}
fact NullIsLeastElement {all t:Type | Null in t.*~xtends}

fact {
	all disj t1, t2 : Type | not (t1 in t2.allExtends or t2 in t1.allExtends) and
		no t1.allSubTypes & t2.allSubTypes => no t1.instance & t2.instance
	all i: Instance, t: i.getType.xtends | i in t.instance
	all a: AbstractType | a.instance = a.allSubTypes.instance
}

/**
 * In the initial state.
 */
fact initialState {
   let l0 = ord/first | l0.level = Object
}

/**
 * Succession condition.
 */
fact succesor {
  all l: Level, l': ord/next[l] {
	l.level.~xtends = l'.level
  }
}

pred ForceMultipleInheritance { some t: Type - Null | #t.xtends >1 }

pred NoAbstractAtLeaf { some a: AbstractType | some a.subTypes }

pred TypeHasInstanceAtLeaf { some t: Type - AbstractType | no t.subTypes and some t.instance }

pred InheritingObject{ all t : Type | Object in t.xtends  => Object = t.xtends }

assert  leafNotAbstractType{
	NoAbstractAtLeaf
	TypeHasInstanceAtLeaf
}
check leafNotAbstractType for exactly 8 Type, exactly 7 Instance, 8 Level

run { ForceMultipleInheritance and InheritingObject} for exactly 8 Type, exactly 7 Instance, 8 Level

run { ForceMultipleInheritance and TypeHasInstanceAtLeaf and InheritingObject} for exactly 8 Type, exactly 7 Instance, 7 Level
