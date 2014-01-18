/*
This Gremlin script creates the core structure of the graph database that
can hold a recipe in a semantic way.
*/

/* Initialise the database */
g = TitanFactory.open('db')

/* Create a few units */
g.addVertex(null,[type:'unit',category:'volume',name:'milliliter',abbr:'ml'])
g.addVertex(null,[type:'unit',category:'weight',name:'gram',abbr:'g'])

g.stopTransaction(SUCCESS)
g.shutdown()

