package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.support.v4.app.m */
class C0090m {

    /* renamed from: android.support.v4.app.m.b */
    public interface C0060b {
        View m179a();
    }

    /* renamed from: android.support.v4.app.m.1 */
    static class C00851 extends EpicenterCallback {
        final /* synthetic */ Rect f243a;

        C00851(Rect rect) {
            this.f243a = rect;
        }
    }

    /* renamed from: android.support.v4.app.m.2 */
    static class C00862 implements OnPreDrawListener {
        final /* synthetic */ View f244a;
        final /* synthetic */ C0060b f245b;
        final /* synthetic */ Map f246c;
        final /* synthetic */ Map f247d;
        final /* synthetic */ Transition f248e;
        final /* synthetic */ ArrayList f249f;

        C00862(View view, C0060b c0060b, Map map, Map map2, Transition transition, ArrayList arrayList) {
            this.f244a = view;
            this.f245b = c0060b;
            this.f246c = map;
            this.f247d = map2;
            this.f248e = transition;
            this.f249f = arrayList;
        }

        public boolean onPreDraw() {
            this.f244a.getViewTreeObserver().removeOnPreDrawListener(this);
            View fragmentView = this.f245b.m179a();
            if (fragmentView != null) {
                if (!this.f246c.isEmpty()) {
                    C0090m.m388a(this.f247d, fragmentView);
                    this.f247d.keySet().retainAll(this.f246c.values());
                    for (Entry entry : this.f246c.entrySet()) {
                        View view = (View) this.f247d.get((String) entry.getValue());
                        if (view != null) {
                            view.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.f248e != null) {
                    C0090m.m391b(this.f249f, fragmentView);
                    this.f249f.removeAll(this.f247d.values());
                    C0090m.m390b(this.f248e, this.f249f);
                }
            }
            return true;
        }
    }

    /* renamed from: android.support.v4.app.m.3 */
    static class C00873 extends EpicenterCallback {
        final /* synthetic */ C0089a f250a;

        C00873(C0089a c0089a) {
            this.f250a = c0089a;
        }
    }

    /* renamed from: android.support.v4.app.m.4 */
    static class C00884 implements OnPreDrawListener {
        final /* synthetic */ View f251a;
        final /* synthetic */ Transition f252b;
        final /* synthetic */ View f253c;
        final /* synthetic */ ArrayList f254d;
        final /* synthetic */ Transition f255e;
        final /* synthetic */ ArrayList f256f;
        final /* synthetic */ Transition f257g;
        final /* synthetic */ ArrayList f258h;
        final /* synthetic */ Map f259i;
        final /* synthetic */ ArrayList f260j;
        final /* synthetic */ Transition f261k;

        C00884(View view, Transition transition, View view2, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4) {
            this.f251a = view;
            this.f252b = transition;
            this.f253c = view2;
            this.f254d = arrayList;
            this.f255e = transition2;
            this.f256f = arrayList2;
            this.f257g = transition3;
            this.f258h = arrayList3;
            this.f259i = map;
            this.f260j = arrayList4;
            this.f261k = transition4;
        }

        public boolean onPreDraw() {
            this.f251a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f252b != null) {
                this.f252b.removeTarget(this.f253c);
                C0090m.m386a(this.f252b, this.f254d);
            }
            if (this.f255e != null) {
                C0090m.m386a(this.f255e, this.f256f);
            }
            if (this.f257g != null) {
                C0090m.m386a(this.f257g, this.f258h);
            }
            for (Entry entry : this.f259i.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int numViews = this.f260j.size();
            for (int i = 0; i < numViews; i++) {
                this.f261k.excludeTarget((View) this.f260j.get(i), false);
            }
            this.f261k.excludeTarget(this.f253c, false);
            return true;
        }
    }

    /* renamed from: android.support.v4.app.m.a */
    public static class C0089a {
        public View f262a;
    }

    public static String m379a(View view) {
        return view.getTransitionName();
    }

    public static Object m376a(Object transition) {
        if (transition != null) {
            return ((Transition) transition).clone();
        }
        return transition;
    }

    public static Object m377a(Object exitTransition, View root, ArrayList viewList, Map namedViews) {
        if (exitTransition == null) {
            return exitTransition;
        }
        C0090m.m391b(viewList, root);
        if (namedViews != null) {
            viewList.removeAll(namedViews.values());
        }
        if (viewList.isEmpty()) {
            return null;
        }
        C0090m.m390b((Transition) exitTransition, viewList);
        return exitTransition;
    }

    public static void m384a(Object transitionObject, View view, boolean exclude) {
        ((Transition) transitionObject).excludeTarget(view, exclude);
    }

    public static void m382a(ViewGroup sceneRoot, Object transitionObject) {
        TransitionManager.beginDelayedTransition(sceneRoot, (Transition) transitionObject);
    }

    public static void m383a(Object transitionObject, View view) {
        ((Transition) transitionObject).setEpicenterCallback(new C00851(C0090m.m389b(view)));
    }

    public static void m385a(Object enterTransitionObject, Object sharedElementTransitionObject, View container, C0060b inFragment, View nonExistentView, C0089a epicenterView, Map nameOverrides, ArrayList enteringViews, Map renamedViews, ArrayList sharedElementTargets) {
        if (enterTransitionObject != null || sharedElementTransitionObject != null) {
            Transition enterTransition = (Transition) enterTransitionObject;
            if (enterTransition != null) {
                enterTransition.addTarget(nonExistentView);
            }
            if (sharedElementTransitionObject != null) {
                C0090m.m390b((Transition) sharedElementTransitionObject, sharedElementTargets);
            }
            if (inFragment != null) {
                container.getViewTreeObserver().addOnPreDrawListener(new C00862(container, inFragment, nameOverrides, renamedViews, enterTransition, enteringViews));
            }
            C0090m.m380a(enterTransition, epicenterView);
        }
    }

    public static Object m378a(Object enterTransitionObject, Object exitTransitionObject, Object sharedElementTransitionObject, boolean allowOverlap) {
        boolean overlap = true;
        Transition enterTransition = (Transition) enterTransitionObject;
        Transition exitTransition = (Transition) exitTransitionObject;
        Transition sharedElementTransition = (Transition) sharedElementTransitionObject;
        if (!(enterTransition == null || exitTransition == null)) {
            overlap = allowOverlap;
        }
        if (overlap) {
            Transition transitionSet = new TransitionSet();
            if (enterTransition != null) {
                transitionSet.addTransition(enterTransition);
            }
            if (exitTransition != null) {
                transitionSet.addTransition(exitTransition);
            }
            if (sharedElementTransition != null) {
                transitionSet.addTransition(sharedElementTransition);
            }
            return transitionSet;
        }
        Transition staggered = null;
        if (exitTransition != null && enterTransition != null) {
            staggered = new TransitionSet().addTransition(exitTransition).addTransition(enterTransition).setOrdering(1);
        } else if (exitTransition != null) {
            staggered = exitTransition;
        } else if (enterTransition != null) {
            staggered = enterTransition;
        }
        if (sharedElementTransition == null) {
            return staggered;
        }
        Transition together = new TransitionSet();
        if (staggered != null) {
            together.addTransition(staggered);
        }
        together.addTransition(sharedElementTransition);
        return together;
    }

    private static void m380a(Transition transition, C0089a epicenterView) {
        if (transition != null) {
            transition.setEpicenterCallback(new C00873(epicenterView));
        }
    }

    private static Rect m389b(View view) {
        Rect epicenter = new Rect();
        int[] loc = new int[2];
        view.getLocationOnScreen(loc);
        epicenter.set(loc[0], loc[1], loc[0] + view.getWidth(), loc[1] + view.getHeight());
        return epicenter;
    }

    private static void m391b(ArrayList transitioningViews, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                transitioningViews.add(viewGroup);
                return;
            }
            int count = viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                C0090m.m391b(transitioningViews, viewGroup.getChildAt(i));
            }
            return;
        }
        transitioningViews.add(view);
    }

    public static void m388a(Map namedViews, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                namedViews.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    C0090m.m388a(namedViews, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void m381a(View sceneRoot, View nonExistentView, Object enterTransitionObject, ArrayList enteringViews, Object exitTransitionObject, ArrayList exitingViews, Object sharedElementTransitionObject, ArrayList sharedElementTargets, Object overallTransitionObject, ArrayList hiddenViews, Map renamedViews) {
        Transition enterTransition = (Transition) enterTransitionObject;
        Transition exitTransition = (Transition) exitTransitionObject;
        Transition sharedElementTransition = (Transition) sharedElementTransitionObject;
        Transition overallTransition = (Transition) overallTransitionObject;
        if (overallTransition != null) {
            sceneRoot.getViewTreeObserver().addOnPreDrawListener(new C00884(sceneRoot, enterTransition, nonExistentView, enteringViews, exitTransition, exitingViews, sharedElementTransition, sharedElementTargets, renamedViews, hiddenViews, overallTransition));
        }
    }

    public static void m386a(Object transitionObject, ArrayList views) {
        Transition transition = (Transition) transitionObject;
        int numViews = views.size();
        for (int i = 0; i < numViews; i++) {
            transition.removeTarget((View) views.get(i));
        }
    }

    public static void m390b(Object transitionObject, ArrayList views) {
        Transition transition = (Transition) transitionObject;
        int numViews = views.size();
        for (int i = 0; i < numViews; i++) {
            transition.addTarget((View) views.get(i));
        }
    }
}
