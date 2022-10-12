Bir uygulama geliştirdiğimizi düşünün. Uygulamamızda kullanıcının bilgi girmesi gereken bir ekran yer alıyor. Ancak gerekli kısımları doldururken son kısımda kullanıcımızın telefonu çalıyor. *Dedikodu zamanı*.

Telefon konuşmasını bitiren kullanıcı uygulamamıza geri dönüyor. Bir de ne görsün? Uygulama kendini yeniden başlatmış ve doldurduğu bütün bilgiler o onaylayamadan buhar olmuş.

Bu noktada, bir Android uygulamasının yaşam döngüsünü (lifecycle) iyi bilmek bu hatadan kaçınmamıza yardımcı olacaktı.

Bu yazımda Android uygulamalarındaki Activity'lerin yaşam döngüsünden, bu yaşam döngüsüne nasıl yaklaşmamız gerektiğinden ve olası sorunlardan bahsedeceğim.

Aşağıdaki görselde bir Activity'nin yaşam döngüsüne ait farklı aşamaları görmektesiniz.

![enter image description here](https://developer.android.com/guide/components/images/activity_lifecycle.png)


Activity'ler `onCreate()` fonksiyonu ile yaşamına başlar ve `onDestroy()` ile yaşam döngüsünü tamamlar. `onCreate()` fonksiyonu, bir uygulamanın başlangıç noktasıdır ancak bu durum bu fonksiyonun yalnızca bir kez çağrılacağı anlamına gelmez. Yazının başındaki senaryoyu dikkate alalım. Kullanıcı, gelen aramaya yanıt verdiğinde uygulamamız arkaplana atılır ve Activity'nin `onStop()` fonksiyonu çalışır. onStop() fonksiyonundan sonra beklediğimiz yön Activity'nin onRestart() ile yeniden ön plana gelmesidir ancak özellikle yetersiz belleğe sahip cihazlarda böyle bir senaryoda arkaplandaki uygulama sonlandırılır ('kill'). Kullanıcı, telefon görüşmesini sonlandırıp uygulamaya döndüğünde `onCreate()` fonksiyonu yeniden çalışmış olur. (Görselin sol kısmına bakın.)

`onCreate()` fonksiyonun yeniden çağrılacağı bir başka durum ise ekranın döndürülmesi durumudur. Bu durumda, sırasıyla `onPause()`>`onStop()`>`onCreate()` fonksiyonları çağrılır ve Activity yaşam döngüsüne yeniden başlar. Dolayısıyla ekran döndürüldüğünde tekrarlanmasını istemediğiniz işlemleri `onCreate()` içinde tutmamamız gerekiyor.
Peki, bu durumları en iyi şekilde nasıl yönetebiliriz? Olası hatalardan kaçınmak için ne yapmamız gerekiyor?
Bu tür değişikliklerde yaşanabilecek sorunlardan kaçınmak uygulamamızın o anki durumunu kaydetmeli ve olası bir yeniden çağrılma durumunda kaydedilen verileri kullanmalıyız. Şimdi bunu yapabileceğimiz farklı çözümleri ele alalım:

### onSaveInstanceState()

Activity'lerin onCreate fonksiyonlarının bir parametre aldığını görmüşsünüzdür. `savedInstanceState` isimli bu parametre, yukarıda bahsettiğimiz gibi durumlardan önce kaydedilen verileri kullanmak için mevcut. Bunu yapabilmek bazı verileri yeniden kullanabilmek üzere kaydetmemiz gerekiyor. State değişimlerinde veri kaydedebilmek için `onSaveInstanceState()` fonksiyonunu kullanabiliriz. Bu fonksiyon `onPause()` ve `onStop()` arasında çağrılır. Gerekli işlemleri burada yapabiliriz.

    var userName: String? = null
    override fun onSaveInstanceState(state: Bundle?) {
        state?.run {
            putString("user_name_key", userName)
        }
    }

Bu şekilde userName değerini kaydedebilir ve daha sonra `onCreate()` içindeki parametre ile veya `onRestoreInstanceState()` fonksiyonu ile bu değeri kullanabiliriz.

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        textView.text = savedInstanceState?.getString("user_name_key")
    }


### ViewModel

MVVM mimarisinin bir parçası olan ViewModel'lar içinde iş mantığını (business logic) tutmakla yükümlüdür. Yani, ekran çevrilmesi gibi state değişikliklerinde kaybolmasını önlemek için verilerimizi burada tutabiliriz.

    class MainViewModel : ViewModel(){
    	var userName: String = ""
    }
    
    class  MyActivity  :  Activity(){
    	private val viewModel: MainViewModel = MainViewModel()
    	// viewModel.userName...
    }

ViewModel, belleğin yetersiz kalıp Activity'nin sonlandırıldığı durumlarda yetersiz kalabilmektedir. Bu durumlarda ViewModel içerisinde bir `SavedStateHandle` nesnesi oluşturabilir ve verilerimizi tıpkı ilk maddede olduğu gibi burada saklayabiliriz.

### Database

İlk iki çözümden daha yavaş olmakla birlikte verileri uygulama kapansa da saklayabileceğimiz diğer bir yöntem bulunuyor, veritabanları. SQLite veya Room gibi kütüphaneler kullanarak verilerimizi cihazımıza kaydedebilir ve durum değişikliklerinde tekrar okuyabiliriz.



