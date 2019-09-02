package diogo.com.br.data.mapper

interface Mapper<in T, out V> {

    fun map(from: T) : V

}