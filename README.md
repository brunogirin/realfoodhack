Real Food Hack: turning food recipes into connected graphs
==========================================================

This is a bit of experimentation with graph databases done at the London
Real Food Hack on 18th Jan 2014.

The code was developed on [Titan](http://thinkaurelius.github.io/titan/)
using the [Groovy](http://groovy.codehaus.org/) implementation of
[Gremlin](https://github.com/tinkerpop/gremlin/wiki).

Setup
-----
- Download and unzip Titan,
- Run the scripts using gremlin (either `gremlin.sh` or `gremlin.bat`
  depending on your operating system)

    $ titan/bin/gremlin.sh < model/init.groovy
    $ titan/bin/gremlin.sh < model/recipe-millat.groovy

Navigate the graph
------------------
You can then run gremlin again and navigate the graph. For instance you can
retrieve the recipe and get a list of ingredients like this:

    gremlin> g = TitanFactory.open('db')
    gremlin> recipe = g.V('type','recipe').has('name',CONTAINS,'Milliat').next()
    gremlin> recipe.out('contains').collect{[it.outE('quantity').value.next(), it.out('quantity').abbr.next(), it.out('ingredient').name.next()]}

