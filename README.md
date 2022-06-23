# Native module sample

## Android - Kotlin

### Data Communication

1. Create new package in `android/app/src/main/java`
2. Create new class file inside your new package.

   - This class will implement `ReactContextBaseJavaModule` class. It'll enable you to create your business logic.
   - `ReactContextBaseJavaModule` requires you to implement `getName` function. This will return your module name.
   - Then, Implement a method you want.

3. Create the package class which implements `ReactPackage` class to expose our module to Javascript.

   - `ReactPackage` requires you to implement 2 method. (`createViewManagers` and `createNativeModules`)

4. Add your package to `PackageList` in `MainApplication.java`

### Event Handler

You can pass the data by emitting the event with `RCTDeviceEventEmitter`.
