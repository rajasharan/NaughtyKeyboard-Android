# Naughty Keyboard for Android

**[The Big List of Naughty Strings](https://github.com/minimaxir/big-list-of-naughty-strings)** is a list of strings which have a high probability of causing issues when used as user-input data.

**Naughty Keyboard for Android** is a very simple android `InputMethodService` that gives you access to a custom keyboard to use these strings to test your application.

## Demo
![](screencast.gif)

## Usage
```bash
$ ./gradlew :app:iD --daemon
```
- Clone this repo, run gradle to install the app.
- Go to android settings, change default input keyboard

## Disclaimer

The **Big List of Naughty Strings** (and this keyboard) is intended to be used for software you own and manage. Some of the *Naughty Strings* can indicate security vulnerabilies, and as a result using such strings with third-party software may be a crime. The maintainer is not responsible for any negative actions that result from the use of the list.

## Links
- [The Big List of Naughty Strings](https://github.com/minimaxir/big-list-of-naughty-strings) (original source)
- [NaughtyKeyboard](https://github.com/Palleas/NaughtyKeyboard) (for iOS)

## [License](/LICENSE)
    The MIT License (MIT)
