import cats.{Applicative, Monad}
import cats.syntax.all._
import com.thoughtworks.dsl.keywords.Monadic.implicitMonadic
import com.thoughtworks.dsl.domains.cats.catsMonadicDsl
import com.thoughtworks.dsl.Dsl.reset

object main {

  def main(args: Array[String]): Unit = {
    import cats.implicits._
    val result = foo[Option](10)
    println(result)
  }

  def foo[F[_]: Monad](i: Int): F[String] = suspend {
    if (!bar + !baz > i) "more"
    else "less"
  }

  def bar[F[_]: Monad]: F[Int] = 1.pure

  def baz[F[_]: Monad]: F[Int] = 2.pure

  def suspend[F[_], A](f: A)(implicit F: Applicative[F]): F[A] @reset = F.pure(f)

}