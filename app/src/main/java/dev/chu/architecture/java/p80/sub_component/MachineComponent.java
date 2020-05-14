package dev.chu.architecture.java.p80.sub_component;

import dagger.Subcomponent;

@Subcomponent(modules = MachineModule.class)
public interface MachineComponent {

    Coffee getCoffee();

    void inject(Machine machine);

    @Subcomponent.Builder
    interface Builder {
        Builder setMachineModule(MachineModule coffeeMachineModule);
        MachineComponent build();
    }

}
