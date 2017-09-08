# MazeMap
## PLTW Senior Capstone Project

This is a project that I made as a part of a team of 3 for my Capstone project in my senior year of highschool. 

## Goals:

- Be able to detect a user's position inside a building without the use of GPS

## Strategy:

- Use a known starting point (i.e. entering the building)
- Use the internial compass to figure out direction of travel
- combine pedometer and accelerometer to estimate travel distance
- dead-recon user's position from last calculatd point

## Results:

- able to track a user for 30 seconds starting from room A140 in my highschool.

The sensor jitter, combined with the double integrtion of acceleration results in sensor drift over time.
This is slightly mitigated by also using pedometer data
