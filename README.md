TabListGridTest
===============

This is Android sample application to use Drag&amp;Drop ListView and Drag&amp;Drop GridView on AppCompat ActionBar Tab.

## Libraries
It is using following Libraries:

 * DynamicListView  
[DevBytes: ListView Cell Dragging and Rearranging](https://www.youtube.com/watch?v=_BZIvjMgH-Q&list=PLWz5rJ2EKKc_XOgcRukSoKKjewFJZrKV0&index=42)

 * DybamicGrid  
[GitHub: DynamicGrid](https://github.com/askerov/DynamicGrid)


## Style Resources
It is using style resources build by following service:

 * [Android Action Bar Style Generator](http://jgilfelt.github.io/android-actionbarstylegenerator/)

## NOT implemented features
 * Drill down list  
When tap list item, show lower level list.  
How to implement it when ListView is in pager view?  
Use getChildFragmentManager ?

 * Data source synchronize  
Now, ListView and GridView are NOT use same data source.  
I'd like to use same data source and sync the order to both of view.  
GridView#setUserVisibleHint is NOT enough for it.  
Because it shows older view while swipe the view.  
