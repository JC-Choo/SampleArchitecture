package dev.chu.architecture.kotlin.p74

import dagger.Component

@Component(modules = [ParentModule::class])
interface ParentComponent {
    fun strings(): Set<String>
    fun childCompBuilder(): ChildComponent.Builder
}