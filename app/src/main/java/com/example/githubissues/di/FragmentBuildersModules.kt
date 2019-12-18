package com.example.githubissues.di

import com.example.githubissues.ui.DetailFragment
import com.example.githubissues.ui.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModules {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment
}