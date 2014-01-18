/*
This Gremlin script creates a recipe for Milliat du Perigord.
Depends on: init.groovy
*/

g = TitanFactory.open('db')

recipe = g.addVertex(null,[type:'recipe',title:'Milliat du Perigord'])

g.stopTransaction(SUCCESS)
g.shutdown()

