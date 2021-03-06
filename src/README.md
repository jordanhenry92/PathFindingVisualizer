## Path-finding Visualizer

This application is a visual representation of how different path-finding algorithms work by showing their path,
as well as the entire traversal path. A user can move the the start and end points, and place "walls", to 
create obstructions.

This is only intended as a side-project for personal learning purposes.

### Built with:
- Java
- JavaFX


### Usage:

An unsolved grid with walls input from user:
![Unsolved Grid](https://i.imgur.com/VvfCyfA.png)

The solved grid after clicking the "Solve" button:
![Solved Grid](https://i.imgur.com/bRbBZuY.png)

- Green point represents the start node.
- Red point represents the end node.
- Dark grey points represent walls.
- Light blue points represent the entire traversal path.
- Dark blue points represent the path found by the algorithm.

Currently the only algorithm implemented (and the one shown above) is Breadth-first search (BFS).

### TODO

- Add functionality to allow the user to change the grid size.
- Implement different types of algorithms (DFS, A*, etc).
- Allow a user to create, save, and load maps to save them from having to re-do them every time (especially for larger grid sizes).