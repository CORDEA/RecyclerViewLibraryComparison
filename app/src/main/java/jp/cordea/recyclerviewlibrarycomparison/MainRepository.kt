package jp.cordea.recyclerviewlibrarycomparison

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor() {
    fun getLanguages(): Single<List<Language>> =
        Single.just(
            listOf(
                Language(
                    "C",
                    listOf("Dennis Ritchie"),
                    ""
                ),
                Language(
                    "C++",
                    listOf("Bjarne Stroustrup"),
                    "https://isocpp.org/"
                ),
                Language(
                    "C#",
                    listOf("Microsoft"),
                    "https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/"
                ),
                Language(
                    "D",
                    listOf("Walter Bright", "Andrei Alexandrescu"),
                    "https://dlang.org/"
                ),
                Language(
                    "Dart",
                    listOf("Lars Bak", "Kasper Lund"),
                    "http://www.dartlang.org/"
                ),
                Language(
                    "Erlang",
                    listOf("Joe Armstrong", "Robert Virding", "Mike Williams"),
                    "http://www.erlang.org/"
                ),
                Language(
                    "F#",
                    listOf("Don Syme", "Microsoft Research"),
                    "http://fsharp.org/"
                ),
                Language(
                    "Fortran",
                    listOf("John Backus"),
                    ""
                ),
                Language(
                    "Go",
                    listOf("Robert Griesemer", "Rob Pike", "Ken Thompson"),
                    "https://golang.org/"
                ),
                Language(
                    "Groovy",
                    listOf("James Strachan"),
                    "http://groovy-lang.org/"
                ),
                Language(
                    "Io",
                    listOf("Steve Dekorte"),
                    "https://iolanguage.org/"
                ),
                Language(
                    "Java",
                    listOf("James Gosling"),
                    "http://oracle.com/java/"
                ),
                Language(
                    "JavaScript",
                    listOf("Brendan Eich"),
                    "https://www.javascript.com/"
                ),
                Language(
                    "Kotlin",
                    listOf("JetBrains"),
                    "https://kotlinlang.org/"
                ),
                Language(
                    "Lisp",
                    listOf("John McCarthy"),
                    ""
                ),
                Language(
                    "Nim",
                    listOf("Andreas Rumpf"),
                    "https://nim-lang.org/"
                ),
                Language(
                    "Perl",
                    listOf("Larry Wall"),
                    "https://www.perl.org/"
                ),
                Language(
                    "R",
                    listOf("Ross Ihaka", "Robert Gentleman"),
                    "https://www.r-project.org/"
                ),
                Language(
                    "Ruby",
                    listOf("Yukihiro Matsumoto"),
                    "https://www.ruby-lang.org/"
                ),
                Language(
                    "Rust",
                    listOf("Graydon Hoare"),
                    "https://www.rust-lang.org/"
                )
            )
        )
}
