package com.example.githubissues.di

import com.example.githubissues.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModules {
    @ContributesAndroidInjector(modules = [FragmentBuildersModules::class])
    abstract fun contributeMainActivity(): MainActivity
}