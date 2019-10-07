# MOMO

MOMO is an Embedded Key-Value store built using Java.

## Getting Started

Following the below instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites
Below softwares needs be installed in prior to run the application
- [Git](https://git-scm.com)
- [Gradle](https://gradle.org/install/)
- Java 1.8
- Any Java-IDE 


### Code Setup & Execution

- Clone the forked repository to your local machine

```bash
git clone  https://github.com/<user-account>/momo.git

# change directory into the repo folder
cd momo

git remote -v
# outputs the origin branch details :
#       origin  https://github.com/<user-account>/momo.git (push)
```

- Create a new feature branch 
```bash
git checkout -b "feature_name"

#Now check the branch
git branch
```
- Build the project
```bash
#Run the below command at the root directory
#where build.gradle is avaibale
gradle build


# under the build/libs/ directory app jar 
# will be available Run the jar
java -jar momo-1.0-SNAPSHOT.jar
```

## Built With

* [Gradle](https://gradle.org/) - Dependency Management
* Java 1.8


## Contributing

Please read [CONTRIBUTING.md](https://github.com/BrainlessLabs/momo/blob/master/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

Check the Release tab

## Authors

See the list of [contributors](https://github.com/BrainlessLabs/momo/blob/master/CONTRIBUTORS.md) who participated in this project.

## License

This project is licensed under the Apache License - see the [LICENSE.md](https://github.com/BrainlessLabs/momo/blob/master/LICENSE) file for details

## Acknowledgments

* Hacktober fest

