# AlloyInEcore
Deep Embedding of Alloy into Essential Meta-object Facility

### Full EMF Type System (`EPackage`, `EClass`, `EEnum`, `EReferences`, `EAttributes` ...)

### `composition` qualifier of an `EReference`

### `identifier` qualifier of an `EAttribute`in an `EClass` to mark as object identifier

### `derived` qualifier of an `EStructuralFeature` to suppress default values 

Perform semantic analysis for 'derived' qualified 'EStructuralFeature' to suppress default values assigned by EMF or by the user or by the reasoning process. Normally, if a value is assigned to a slot, the reasoning process includes the current value in the lower bound, that gurantees this assigned is unchanged. However, if this value is unknown before the analysis and it should be derived from the structure of the state, then the user should mark the structural feature corresponding to this slot.

Delete any values on the slots of `derived` qualified `EAttributes` or `EReferences` of an user provided partial instance. The values on the state before analysis is `volatile`.

1. `EBoolean <- false`
2. `EInteger <- 0

```
import Ecore : 'http://www.eclipse.org/emf/2002/Ecore';

package ArchitectureMetamodel : arch = 'eu.modelwriter.demonstrations.metamodels.architecture'
{
    public class one ArchitecturalModel
    {
        property one elements : ArchitecturalElement[*] { composes };
        model property leaves : Component[*];
        invariant leaves: Component - Component.^~subComponents in ArchitecturalModel.leaves;
        
    }
    abstract class ArchitecturalElement [7]
    {
        attribute identifier : Integer[1] {id}; 
--		invariant : all disj a, b: ArchitecturalElement | a.identifier != b.identifier;
        attribute name : String[?];
--      invariant : all a: Component| #a.subComponents < 3;
        invariant : all c: Component | some c.subComponents implies #a.subComponents = 2;
    }
    class Component extends ArchitecturalElement
    {
        property subComponents : Component[*] { composes };
        ghost attribute description: String = 'Default Description';      
        
        model attribute isLeaf: Boolean { derived };      
        invariant isLeaf: all c: Component | some (c - c.^r) implies c.isLeaf = True;
    
    }
}
```

### Generic types (`EGeneric`) and type parameters, (`ETypeParameter`)

### String, Integer, and Boolean Values in constraints

#### Reasoning about `EBoolean` attributes

#### Reasoning about `EString` attributes

#### Reasoning about `EInteger` attributes

#### Reasoning about `EEnum` and `EEnumLiterals`

### `class`, `extends`, and `super` in constraints

This feature is inspired from `java.lang.Class` of the java language.
1. `Class` is a unary relation and has exact bounds since the number of `EClass` specified on an EMF model is fixed (finite).
`Class: [[[Object], [List], [List<Object>], [List<?>] ... ]]`  
`Class` also represents `Class<?>`  
2. Each `Class<T>` is a singleton as shown below:   
`Class<Object>: [[[Object]]]`   
`Class<List>: [[[List]]]`   
`Class<List<Object>>: [[[List<Object>]]]`  
`Class<List<?>>: [[[List<?>]]]`  
`...`
3. All `Class<T>` singletons constitute the set of raw `Class`.    
`Class =  Class<Object> + Class<List> + Class<List<Object>> + Class<List<?>> ... `    
4. `type` is a binary relation. Each atoms excluding the set of `Class` in the universe has **at least one type** based on the type hierarchy specified in the EMF file.   
`<EnginedVehicle281>.type = {<EnginedVehicle>, <Vehicle>, <Object>}`  
`<EnginedVehicle181>.type = {<EnginedVehicle>, <Vehicle>, <Object>}`  
`<EnginedVehicle281>.type = <EnginedVehicle181>.type`  
5. If the tuple comes from partial instance then the lower and upper bounds are fixed.  
`type: {<EnginedVehicle281, EngineVehicle>, <EnginedVehicle281, Vehicle>, <EnginedVehicle281, Object>, <EngineVehicle, EngineVehicle>, <EngineVehicle, Vehicle>, <EnginedVehicle, Object>, ...}`  
6. The set of `Class` is disjoint from all other sets.  
`no (Class & (Object + List + ... )`  
7. The set of `type` is the subset of the production from **`univ`** to **`Class`**.  
`type in (univ - Class) -> some Class`  
If we apply the bounds on the set of `type`, then the we should specify the following rule:  
`type in univ -> some Class`  
8. The Classes, Objects, StringLiterals, and Numbers form the universe.  
`univ = {<Object>, <List>, <List<Object>>, <List<?>>, ... , <EnginedVehicle281>, <Vehicle_1>, <EnginedVehicle181>, ... , <"Ferhat">, <EString_1>, <EString_2>, ... , <EInt_1>, <5>,  <EInt_7>, <9.5>, ...  }`
9.  Mapping from each set to the corresponding type.  
`all a: univ - Class | a in Object iff Class<Object> in a.type`  
`all a: univ - Class | a in List iff Class<List> in a.type`  
`all a: univ - Class | a in List<Object> iff Class<List<Object>> in a.type`  
`all a: univ - Class | a in List<?> iff Class<List<?>> in a.type`  
`...`  
10. From the the type system, the following axioms already exist:  
`no Object & List`  
`...`  
`Vehicle in Object`  
`EnginedVehicle in Vehicle`  
`...`  
`List = List<Object> + List<Vehicle> + List<EnginedVehicle>`  
`List<?> in List`  
These axioms enforce the consistency among types based on the type hierarchy. Consequently, the following assertions are always true:  
11. The assertions such as the following ones must always be true:  
`assert { all a: univ  | a.type in Class<List<EnginedVehicle>> implies (a.type in Class<List<Vehicle>> and a.type in Class<List<Object>> }`  
`assert { all disj o, o': univ - Class |  (o'.type in o.type) implies (o' in o) }`  
`assert { all v: Vehicle | Class<EnginedVehicle> in v.type}`  
`assert { all c: Class |  some o : univ | c in o.type }`  
12. `type` is a partial order over the set `Class`.  
`reflexive[type, Class]`  
`antisymmetric[type]`  
`transitive[type]`  
13. The following equalities must hold adding respective type tuples to the set of `type`.  
`Class<EnginedVehicle>.type = {<EnginedVehicle>, <Vehicle>, <Object>}`  
`Class<Vehicle>.type = {<Vehicle>, <Object>}`  
`Class<Object>.type = {<Object>}`  
14. generation `extends` and `super` relations  
`all c, c' : Class | (c.type in c'.type and c'.type !in c.type) iff c in c'.extends`  
`super = ~extends`  
15. The following rule must hold because of the above first axiom:  
`extends in Class -> Class`  
16. `extends` and `super` are irreflexive, antisymmetric, and transitive.   
`irreflexive[extends]`   
`antisymmetric[extends]`  
`transitive[extends]`  

- The intended usage in the Theory of List in the AlloyInEcore context:  

```
-- type(class) in univ -> set TYPE (java.lang.Class)  
-- a.type = b.type  
-- a.class = b.class    
-- type[a] = type[b]  
all a, b: List<E> | a in b.eq iff (a.car = b.car and a.cdr in b.cdr.eq and a.type != b.type);
all a, b: List<E> | a in b.eq iff (a.car = b.car and a.cdr in b.cdr.eq and a.type in b.type.extends);
```

### `model` and `ghost` attirubute and references.

### Predefined keywords for EReferences inspired by Alloy's `Relation` and `Graph` Libraries

### Instance Visualization

### Finite Implementation of Transitive Closure Operator of Alloy by Z3

* Unroll transitive closure operator and estimate the maximum number of join operation.

`^r = r + r.r + r.r.r + ...`

> For a finite universe, transitive closure needs only a finite unwinding,
> limited by the length of the longest path in the graph. 

> Viewing a relation as a graph, the transitive closure represents reachability.

```
address = 
 {(G0, A0), (G0, G1), (A0, D0), (G1, D0), (G1, A1), (A1, D1), (A2, D2)}
```
```
'The length of the longest path in the graph' = 
 #{(G0, G1), (G1, A1), (A1, D1)} = 3
```
```
address = 
 {(G0, A0), (G0, G1), (A0, D0), (G1, D0), (G1, A1), (A1, D1), (A2, D2)}
address.address = 
 {(G0, D0), (G0, A1), (G1, D1)}
address.address.address = 
 {(G0, D1)}
```
```
^address = address + address.address + address.address.address
 {(G0, A0), (G0, G1), (A0, D0), (G1, D0), (G1, A1), (A1, D1), (A2, D2),
 (G0, D0), (G0, A1), (G1, D1),
 (G0, D1)}
^address - address = {(G0, D0), (G0, A1), (G1, D1), (G0, D1)}
```

* An example is shown in the following:

```
(all d: Dir | !(d in (d.(^content)))) 

(all d: Dir | !(d in (d.(content)))) 
(all d: Dir | !(d in (d.(content.content)))) 
(all d: Dir | !(d in (d.(content.content.content)))) 
                        ...
```
```
(all l: List | Nil in (l.(*cdr)))

(all l: List | Nil in (l.((cdr + iden))))
(all l: List | Nil in (l.((cdr + iden).(cdr + iden))))
(all l: List | Nil in (l.((cdr + iden).(cdr + iden).(cdr + iden))))
                        ...
```


```
(all d: Dir | !(d in (d.(content)))) <=> (all d: Dir | (d -> d)  !in content) 
```
```
all d, d': Dir | content(d,d') implies d != d'
all d, d', d'': Dir | content(d,d') and content(d',d'') implies d != d''
all d, d', d'',d''': Dir | content(d,d') and content(d',d'') and content(d'',d''') implies d != d'''
...
```

```
(declare-sort FSObject)
(declare-fun isDir (FSObject) Bool)
(assert (forall ((f FSObject)) (=> (isDir f) (isFSObject f))))
(declare-fun content (FSObject FSObject) Bool)
(declare-fun trcontent1 (FSObject FSObject) Bool)
(declare-fun trcontent2 (FSObject FSObject) Bool)
(declare-fun trcontent3 (FSObject FSObject) Bool)

all d, d', d'': Dir | content(d,d') and content(d',d'') implies trcontent1(d , d'')
all d, d', d'': Dir | trcontent1(d , d') and content(d',d'') implies trcontent2(d , d'')
all d, d', d'': Dir | trcontent2(d , d') and content(d',d'') implies trcontent3(d , d'')

all d, d': Dir | content(d,d') implies d != d'
all d, d': Dir | trcontent1(d,d') implies d != d'
all d, d': Dir | trcontent2(d,d') implies d != d'
all d, d': Dir | trcontent3(d,d') implies d != d'
```
![image](https://github.com/ModelWriter/AlloyInEcore/blob/aie-interpreter/Documents/FinitizationTransitiveClosureForSMTLIB.png)

```
all d: FSObject | isDir(d) implies not content(d,d)
all d: FSObject | isDir(d) implies not trcontent1(d,d)
all d: FSObject | isDir(d) implies not trcontent2(d,d)
```

```
all d: Dir | not content(d,d)
all d, d': Dir | not (content(d,d') and content(d',d))
all d, d': FSObject | (isDir(d) and isDir(d')) implies not (content(d,d') and content(d',d))
....
```
```
forall d: FSObject, d': FSObject | isDir(d) implies not (content(d, d') and content(d',d) )
```



