/*
This Gremlin script creates a recipe for Milliat du Perigord.
Depends on: init.groovy
*/

g = TitanFactory.open('db')

recipe = g.addVertex(null,[type:'recipe',name:'Milliat du Perigord',portions:12])
// units
ukg = g.V('type','unit').has('name','kilogram').next()
uu = g.V('type','unit').has('name','unit').next()
ug = g.V('type','unit').has('name','gram').next()
uml = g.V('type','unit').has('name','milliliter').next()
utsp = g.V('type','unit').has('name','tea spoon').next()
utbsp = g.V('type','unit').has('name','table spoon').next()
upinch = g.V('type','unit').has('name','pinch').next()
// ingredients
// 1.5kg squash
isquash = g.V('type','ingredient').has('name','squash').next()
rsquash = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, rsquash, 'contains')
g.addEdge(rsquash, isquash, 'ingredient')
g.addEdge(rsquash, ukg, 'quantity', [value:1.5])
// 5 eggs
iegg = g.V('type','ingredient').has('name','egg').next()
regg = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, regg, 'contains')
g.addEdge(regg, iegg, 'ingredient')
g.addEdge(regg, uu, 'quantity', [value:5])
// 200g sugar
isugar = g.V('type','ingredient').has('name','sugar').next()
rsugar = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, rsugar, 'contains')
g.addEdge(rsugar, isugar, 'ingredient')
g.addEdge(rsugar, ug, 'quantity', [value:200])
// 1 tea spoon vanilla sugar
ivsugar = g.V('type','ingredient').has('name','vanilla sugar').next()
rvsugar = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, rvsugar, 'contains')
g.addEdge(rvsugar, ivsugar, 'ingredient')
g.addEdge(rvsugar, utsp, 'quantity', [value:1])
// 150g ground almonds
ialmond = g.V('type','ingredient').has('name','ground almond').next()
ralmond = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, ralmond, 'contains')
g.addEdge(ralmond, ialmond, 'ingredient')
g.addEdge(ralmond, ug, 'quantity', [value:150])
// 4 table spoon flour
iflour = g.V('type','ingredient').has('name','flour').next()
rflour = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, rflour, 'contains')
g.addEdge(rflour, iflour, 'ingredient')
g.addEdge(rflour, utbsp, 'quantity', [value:4])
// 100ml milk
imilk = g.V('type','ingredient').has('name','milk').next()
rmilk = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, rmilk, 'contains')
g.addEdge(rmilk, imilk, 'ingredient')
g.addEdge(rmilk, uml, 'quantity', [value:100])
// 30g butter
ibutter = g.V('type','ingredient').has('name','butter').next()
rbutter = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, rbutter, 'contains')
g.addEdge(rbutter, ibutter, 'ingredient')
g.addEdge(rbutter, ug, 'quantity', [value:30])
// 1 pinch salt
isalt = g.V('type','ingredient').has('name','salt').next()
rsalt = g.addVertex(null,[type:'recipe-ingredient'])
g.addEdge(recipe, rsalt, 'contains')
g.addEdge(rsalt, isalt, 'ingredient')
g.addEdge(rsalt, upinch, 'quantity', [value:1])

/*
Select all ingredients:
recipe = g.V('type','recipe').has('name',CONTAINS,'Milliat').next()
recipe.out('contains').collect{[it.outE('quantity').value.next(), it.out('quantity').abbr.next(), it.out('ingredient').name.next()]}
*/

g.stopTransaction(SUCCESS)
g.shutdown()

