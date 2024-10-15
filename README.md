# Library Management System

## Project Overview
The Library Management System is a Spring Boot application designed to facilitate the management of library books. It allows users to perform various operations such as adding, updating, deleting, and viewing books in the library. This project aims to demonstrate the use of Spring Boot, JPA (Java Persistence API), and MySQL as the database to create a functional and user-friendly library management application.

## Table of Contents
1. [Entity Fields](#entity-fields)
2. [Git and GitHub Commands Guide](#git-and-github-commands-guide)

---

## Entity Fields

### Book Entity
The `Book` entity represents a book in the library system. Below are the fields included in the entity, along with their descriptions:

| Field Name        | Description                                                                                                                                     |
|-------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| `title`           | The title of the book. It represents the main name under which the book is published.                                                         |
| `author`          | The author of the book. This field captures the person or entity who wrote the book.                                                          |
| `isbn`            | A unique identifier for books, known as the International Standard Book Number. This ensures that each book can be distinctly recognized.     |
| `publisher`       | The company or entity that published the book, providing information about where the book was produced.                                        |
| `publicationDate` | The date when the book was published, allowing users to see when the book was released.                                                       |
| `category`        | The genre or category of the book, such as fiction, non-fiction, fantasy, etc. This helps in organizing and searching for books by genre.     |
| `pages`           | The number of pages in the book. This field provides users with an idea of the length of the book.                                            |
| `language`        | The language in which the book is written, indicating the language for reading the book.                                                      |
| `copiesAvailable` | The number of copies available for borrowing, informing users how many copies they can check out from the library.                             |
| `location`        | The shelf or section where the book is stored in the library, which helps users find the book in the physical library space.                   |

---

## Git and GitHub Commands Guide

### Creating a Repository
**Command:** `git init`  
**Description:** Initializes a new Git repository in your project directory.  
**Example:**
- Create a new directory: `mkdir my-project`
- Change into the directory: `cd my-project`
- Initialize Git: `git init`

### Cloning a Repository
**Command:** `git clone <repository-url>`  
**Description:** Clones a remote repository to your local machine, creating a local copy of the repository.  
**Example:** 
- `git clone https://github.com/gbetibienvenu/repository.git`

### Creating Branches
**Command:** `git branch <branch-name>`  
**Description:** Creates a new branch in your repository to facilitate separate development lines.  
**Example:** 
- `git branch feature-branch`

### Committing Changes
**Commands:**
- `git add <file-name>`
- `git commit -m "Your commit message"`  
**Description:** 
- The `git add` command stages your changes.
- The `git commit` command creates a commit with a message explaining the changes.  
**Example:** 
- `git add README.md`
- `git commit -m "Add README file"`

### Reverting Commits
**Command:** `git revert <commit-hash>`  
**Description:** Reverts a specific commit and creates a new commit that undoes the changes made by the specified commit.  
**Example:** 
- `git revert absd1233`

### Pulling and Pushing Changes
**Commands:**
- `git pull origin <branch-name>`
- `git push origin <branch-name>`  
**Description:** 
- `git pull` fetches and merges changes from the remote repository.
- `git push` sends your local changes to the remote repository.  
**Example:** 
- `git pull origin main`
- `git push origin main`

### Fetching Changes
**Command:** `git fetch`  
**Description:** Retrieves changes from the remote repository without merging them into your current branch.  
**Example:** 
- `git fetch origin`

### Merging Branches
**Command:** `git merge <branch-name>`  
**Description:** Merges changes from one branch into another, typically from a feature branch into the main branch.  
**Example:** 
- `git merge feature-branch`

### Renaming Branches
**Command:** `git branch -m <new-branch-name>`  
**Description:** Renames the current branch to a new name, allowing for better clarity in branch naming.  
**Example:** 
- `git branch -m new-branch-name`

### Creating Pull Requests
**Description:** Pull requests can be created via the GitHub interface. Navigate to your repository, switch to your feature branch, and click on "New Pull Request."

### Reviewing and Merging Pull Requests
**Description:** Once a pull request is made, it can be reviewed and merged using the GitHub web interface. Collaborators can provide feedback or approve the changes.

### Reverting Pull Requests
**Command:** `git revert -m 1 <merge-commit-hash>`  
**Description:** Reverts a merged pull request by providing the commit hash of the merged pull request, effectively undoing the changes made by the pull request.  
**Example:** 
- `git revert -m 1 hashnumberhere`

---

# Conclusion
This README file provides a comprehensive guide to the Library Management System project, detailing the essential fields used in the book entity and a list of key Git and GitHub commands. This structure is aimed at helping users understand both the application functionality and the version control processes involved in managing the project.
