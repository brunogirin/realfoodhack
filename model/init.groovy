/*
This Gremlin script creates the core structure of the graph database that
can hold a recipe in a semantic way.
*/

/* Initialise the database */
g = TitanFactory.open('db')

/* Create a few units */
g.addVertex(null,[type:'unit',category:'volume',name:'milliliter',abbr:'ml'])
gram = g.addVertex(null,[type:'unit',category:'weight',name:'gram',abbr:'g'])
kgram = g.addVertex(null,[type:'unit',category:'weight',name:'kilogram',abbr:'kg'])
g.addEdge(kgram, gram, 'converts-to', [ratio:1000])
g.addVertex(null,[type:'unit',category:'unit',name:'unit',abbr:''])
g.addVertex(null,[type:'unit',category:'volume',name:'tea spoon',abbr:'tsp'])
g.addVertex(null,[type:'unit',category:'volume',name:'table spoon',abbr:'tbsp'])
g.addVertex(null,[type:'unit',category:'volume',name:'pinch',abbr:'pinch'])

/* Create a few ingredients */
g.addVertex(null,[type:'ingredient',name:'squash'])
g.addVertex(null,[type:'ingredient',name:'egg'])
sugar = g.addVertex(null,[type:'ingredient',name:'sugar'])
vsugar = g.addVertex(null,[type:'ingredient',name:'vanilla sugar'])
g.addEdge(vsugar, sugar, 'derived-from',[method:'flavour'])
almond = g.addVertex(null,[type:'ingredient',name:'almond'])
galmond = g.addVertex(null,[type:'ingredient',name:'ground almond'])
g.addEdge(galmond, almond, 'derived-from',[method:'ground'])
g.addVertex(null,[type:'ingredient',name:'flour'])
g.addVertex(null,[type:'ingredient',name:'milk'])
g.addVertex(null,[type:'ingredient',name:'butter'])
g.addVertex(null,[type:'ingredient',name:'salt'])

g.stopTransaction(SUCCESS)
g.shutdown()

