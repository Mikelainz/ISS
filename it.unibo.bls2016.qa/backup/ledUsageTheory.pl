/*
===============================================================
ledUsageTheory.pl
===============================================================
*/
turnTheLed( on ) :- turnOn.	
turnTheLed( off ):- turnOff.

%% Led 'public' operations (ILed interface) %%

isOn  :-
    class("it.unibo.devices.qa.DeviceLedFactoryQa") <- getTheLed  returns LED,
	LED <- isOn.
turnOn :-
	class("it.unibo.devices.qa.DeviceLedFactoryQa") <- getTheLed  returns LED,
	LED <- turnOn.
turnOff :-
	class("it.unibo.devices.qa.DeviceLedFactoryQa") <- getTheLed  returns LED,
	LED <- turnOff.
doSwitch :-
	class("it.unibo.devices.qa.DeviceLedFactoryQa") <- getTheLed  returns LED,
	LED <- doSwitch.