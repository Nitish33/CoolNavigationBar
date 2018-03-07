# CoolNavigationBar

<html>
<body>

<h1> Cool Menu</h1>

<p>
  In this project i have implement a menu using view pager. I first tried it will Navigation bar , so the name of the project.
 <br>
 To implement this menu , i have used view pager. First and third page are the menu page , and second page is our content</br>
 frame.
 <br><br>
 When we slide our page , say left to right. when first menu appear. What i have done is.
 <or>
 <li>Set the page translation of first page (one with negative position offset) to 0</li>
 <li> Resize The content page</li>
 <li> Shift the content page to align to parent right</li>
</p>

<img src = "/image/view pager.gif"></src>

<h2> Implementing Page Transformation</h2>
<p>
PageTransformer is the interface which will control all our transformation.
</p><br>
<code>
 @Override
    public void transformPage(@NonNull View page, float position) {

        if(position<-1)
            page.setAlpha(0);
        else if(position>1)
            page.setAlpha(0);

        else page.setAlpha(1);


        if(page.getId() == R.id.menu){
            page.setTranslationX(-position*page.getWidth());
        }

        else if(page.getId() == R.id.content){

            if(position>0) {

                float pos = Math.abs(position);
                float scale = Math.max(.5f, 1 - pos);
                page.setScaleY(scale);
                page.setScaleX(scale);

                float pageWidth = page.getWidth();
                float pageScaleWidth = scale * pageWidth;
                float deltaWidth = pageWidth - pageScaleWidth;

                page.setTranslationX((1 - position) * page.getWidth() - pageScaleWidth - deltaWidth / 2);


                Log.e(TAG, "transformpage : content" + page.getWidth() + " " + deltaWidth
                        + "  " + pageScaleWidth);

            }

            else if(position<0){
                float pos = Math.abs(position);
                float scale = Math.max(.5f, 1 - pos);
                page.setScaleY(scale);
                page.setScaleX(scale);

                float pageWidth = page.getWidth();
                float pageScaleWidth = scale * pageWidth;
                float deltaWidth = pageWidth - pageScaleWidth;

                page.setTranslationX(-position* page.getWidth()-deltaWidth/2);


                Log.e(TAG, "transformpage : content" + page.getWidth() + " " + deltaWidth
                        + "  " + pageScaleWidth);

            }
        }

        else if(page.getId() == R.id.menu2){
            page.setTranslationX(-position*page.getWidth());
            Log.e(TAG, "transformPage: menu 2" );
        }
        else
        Log.e(TAG,"something wrong");
    }
</code>


