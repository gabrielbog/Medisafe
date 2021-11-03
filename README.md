# Medisafe
Our project theme is personalized medicine.

# Features Shipped
- [x] login
- [x] signup
- [x] create appointments
- [x] database communication

# Design
![medisafe](docs/design/Medisafe.png)

Design created using [figma](https://www.figma.com).

# Programs and libraries hosted in this solution
- [junit](https://junit.org/junit5/) - Unit testing
- [mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java) - Java JDBC
- [xampp](https://www.apachefriends.org/index.html) - Used for MYSQL db hosting

# Supported platforms / recommended toolchains
The following are recommended toolchains for popular platforms.

Windows [Intellij IDEA](), Java SDK 17. 

# Build system generation
```bash
mvn package
```
# Github Organization
First, click on the **Fork button** in the top-right corner. 

![fork](docs/fork.jpeg)

This creates a new copy of this repository under your GitHub user account with a URL like:
```bash
https://github.com/<YourUserName>/Medisafe
```

---

Next, clone the repo by opening the terminal on your computer and running the command:

```bash
git clone https://github.com/<YourUserName>/Medisafe.git
```

---

Create a new remote for the upstream repo with the command:
```bash
git remote add upstream https://github.com/vasilecampeanu/Medisafe
```
Why do I need to do this ?
</br>
Well, when a repository is cloned, it has a default remote called **origin** that points to your fork on GitHub, not the original repository it was forked from. To keep track of the original repository, you need to add another remote named. So, if you want to be able to keep track of the changes that are made by other members of the team you need to complete this step.

---

Medisafe branches:

![branches](docs/branches.png)

Once the repo is cloned, you want to switch to **development** branch. For that, run the following command:

```bash
git checkout develop
```

Why do I need to do this ?
<br>
Because the **main branch** will be preserved only for changes that are tested and stable. Using a development branch is good practice because it kips the main branch clean, macking the end user experience better, by reducing the likelihood of bugs and unintended errors.

Now that you are on the development branch you can make you contribution.

---

After you finised your tasks, you want commit your changes:

```bash
git add *
git commit -m "feat: Your message"
```

After you commited your changes is time to push them to the remote repository:

```bash
git push -u origin develop
```

---

How do i get the changes tht are made by my teammates ?

To pull the changes from the upstream repository run the following command:

```bash
git fetch upstream
git rebase upstream/develop
```

# Contributors
- Bogoslov Ioan Gabriel
    - Backend
    - Implemented the logic and classes behind the login system and appointemnts
    - UML Diagrams
- Vasile Campeanu
    - Github Organization/Documentation
    - Interface design
    - Database Implementation
- Iagar Catalin
    - Front end
    - Implemented the graphical interface and all user interactions
    - UML Diagrams