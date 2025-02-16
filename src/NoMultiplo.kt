data class NoMultiplo(var dado: String) {
    var id: Int = 0;
    var genitor: NoMultiplo? = null
    val arrayPointers: Array<NoMultiplo?> = arrayOfNulls(5);
}