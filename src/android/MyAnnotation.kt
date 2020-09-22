package android

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyAnnotation(val value: Int)

private fun bindReflectionValue(target: Any) {
    val declaredFields = target::class.java.declaredFields

    for (field in declaredFields) {
        for (annotation in field.annotations) {
            when (annotation) {
                is MyAnnotation -> {
                    field.isAccessible = true
                    field.set(target, annotation.value)
                }
            }
        }
    }
}