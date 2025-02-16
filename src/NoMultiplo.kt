data class NoMultiplo(var dado: String) {
    var genitor: NoMultiplo? = null
    val arrayPointers: Array<NoMultiplo?> = arrayOfNulls(5);
}