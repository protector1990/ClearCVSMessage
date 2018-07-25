# ClearVCSMessage
Plugin that clears commit message from commit window after a successful commit.  
After installation, plugin functionality will be enabled by default. To toggle it on and off, use VCS (menu) -> Clear message on successful commit. This is a global setting, meaning it will be the same across all projects.

# Why this plugin?
It has been happening to me now and then to commit to the repository without checking the commit message, so I end up with a commit with a message that is actually from the last one and doesn't have anything to do with the current commit. Setting Intellij to clear initial commit message every time also doesn't work, since it also happens to me a lot to type in a message, realize that there is something that I've forgot to do, close the commit window and do whatever in the code, and when I reopen it, the message is gone.
So, I wanted something in between - keep my commit messages, but only until I actually perform a commmit. This plugin enables that functionality, it keeps the message until you actually commit, and the next time you open commit window, there will be no message.

# Limitations
This plugin works by listening for successful commit events within Intellij VCS - it cannot detect successful commits performed outside of intellij (e.g. from git command line).
