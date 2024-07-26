# CityMap - Random City Map Generator with GraphStream

## Overview

CityMap is a Java application that generates a random map of 100 cities with roads connecting them and visualizes the map using the GraphStream library. The roads have different lane types, which are visually differentiated in the graph.

## Features

- Generates 100 random cities with unique names, latitude, and longitude values.
- Connects cities with roads of varying lane types:
    - 4 lanes: National Highways
    - 3 lanes: Inter-State Highways
    - 2 lanes: Highways
    - 1 lane: Main Roads
- Ensures each city is connected to at least one other city.
- Visualizes the cities and roads using GraphStream, with different colors and sizes for different lane types.
  
- The City class represents a city with a name, latitude, and longitude.
- The Road class represents a road connecting two cities, with a specified number of lanes.
- The main application generates cities and roads, and visualizes them using GraphStream