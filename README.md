## This demo project is to test the performance of Paint#setAlpha
1.Find SetAlphaBenchmark.kt under androidTest in benchmark module.  
2.Plugin your device to your computer, make sure battery need to be charged to at least 25%.  
3.Right click SetAlphaBenchmark.kt and select "Profile 'SetAlphaBenchmark'".  
4.See the results like below in 'Run' tab.

>benchmark:    16,179,917 ns SetAlphaBenchmark.drawBitmap  
>benchmark:       843,750 ns SetAlphaBenchmark.setAlpha  

Please also refer to the link below to start your own benchmark:  
https://developer.android.com/studio/profile/benchmark  
https://github.com/android/performance-samples  
