## Goal:
- have the crawler start from an initial webpage
- when it encounters more than one link, it splits up into different threads
- Each thread locks the website they are trying to visit (so that no more threads can go down that path)
- Each thread terminates when there are no more unlocked links on a page
- As the crawler crawls the website, it stores information regarding things inside a tree-like data structure
- I will use this tree-like data structure in order to actually generate a diagram with that tree-like structure