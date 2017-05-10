[![Codacy Badge](https://api.codacy.com/project/badge/Grade/6808a4f5333e4f73a0ebeac78b3fe57b)](https://www.codacy.com/app/pablogarciamiranda/parti_i3a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/parti_i3a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/parti_i3a.svg?branch=master)](https://travis-ci.org/Arquisoft/parti_i3a)
[![codecov](https://codecov.io/gh/Arquisoft/parti_i3a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/parti_i3a)
[![GuestUsers Heroku](https://img.shields.io/badge/View%20on-Heroku-ff69b4.svg)](http://participants-i3a.herokuapp.com/participants_i3a/) 


# Description

This repository contains the project for the Software Architecture subject.

The purpose of the project is create a web application for the town hall, which will be in charge of managing the citizen participation. The citizens will have the possibility of make proposals which will be voted and commented by other users. The council staff will use this application to decide which are the best proposals of the city.

The dashboard will be responsible of updating the information dynamically and in real time without user interaction. It will reflect the changes that are produced through a small testing simulator that generate random events such as Proposals, Votes and Comments to the Kafka Stream.

# Project

When you start the application, you can use one of this links:
- [Participants](http://participants-i3a.herokuapp.com/participants_i3a). In this link, you can manage your account.
- [Dashboard](http://localhost:8080/dashboard_i3a). In this link, you can view the participation statistics

To use these services, the first thing you have to do is provide some credentials to access. If you don't have any credentials, you can't use the web application.

# Wiki

In our [wiki](https://github.com/Arquisoft/parti_i3a/wiki) you can find information about the [versions of the project and the meetings we have done during the development](https://github.com/Arquisoft/parti_i3a/wiki/Versions-and-meetings).

You can have also have the [quality attributes](https://github.com/Arquisoft/parti_i3a/wiki/Quality-Attributes) and [quality scenarios](https://github.com/Arquisoft/parti_i3a/wiki/Quality-Scenarios) of our project.

Our [Wiki of the Tests](https://github.com/Arquisoft/parti_i3a/wiki/Testing) show information about all kind of tests that we have developed.


You can also find other pages helping you in how to run the project ([How to lunch participants](https://github.com/Arquisoft/parti_i3a/wiki/How-to-lunch-Participants) or [how to run dashboard](https://github.com/Arquisoft/parti_i3a/wiki/How-to-run-Dashboard))

# Collaborators

- **Fernando Freije Fuente** (_[@fernandofreije](https://github.com/fernandofreije)_)
- **David García González** (_[@dgsama](https://github.com/dgsama)_)
- **Pablo García Miranda** (_[@pablogarciamiranda](https://github.com/pablogarciamiranda)_)


**Thanks for read this file. If you have any question or any problem you can contact with us.**
>Programming without an overall architecture or design in mind is like exploring a cave with only a flashlight: You don't know where you've been, you don't know where you're going, and you don't know quite where you are. - Danny Thorpe
